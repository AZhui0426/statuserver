package com.azhui.statuserver.common.utils;

/**
 * @author xianchun
 * @description 用于生成简码, 简码由8个字节分5部分组成
 * 0 0000000000000000000000000000000000000000000 000 00000 000000000000
 * 1.首位标识符号固定为0 1bit
 * 2.时间戳          43 bit
 * 3.集群中心序号     3 bit
 * 4.集群中机器编号   5 bit
 * 5.序列号          12 bit
 * @date 9:49 2020/12/22
 */
public final class ShortCodeGenerator {

    private long centerId;
    private long machineId;
    private long sequence = 0L;
    //系统当前最新的时间
    private long lastTimestamp = -1L;

    /*位移数量*/
    private final int centerIdBits = 3;
    private final int machineIdBits = 5;
    private final int timestampBits = 43;
    private final int sequenceBits = 12;

    /*时间戳和集群中心位移值*/
    private final int timestampShiftBits = sequenceBits + centerIdBits + machineIdBits;
    private final int centerShiftBits = sequenceBits + machineIdBits;

    private final long maxCenterId = -1L ^ (-1L << this.centerIdBits);
    private final long maxMachineId = -1 ^ (-1L << this.machineIdBits);
    private final long maxSequence = -1 ^ (-1L << this.sequenceBits);
    //2020.12.22
    private final long epoch = 1608604210L;

    /**
     * @param centerId  数据中心编码 取值范围 0~7
     * @param machineId 机器序号 取值范围 0~31
     * @return
     * @desciption ShortCodeGenerator 主键生成器
     * @author xianchun
     * @date 9:54 2020/12/29
     */
    public ShortCodeGenerator(long centerId, long machineId) {
        if (centerId > this.maxCenterId || centerId < 0) {
            throw new IllegalArgumentException("the center id is illegal,the value rang 0 to " + this.maxCenterId);
        }
        if (machineId > this.maxMachineId || machineId < 0) {
            throw new IllegalArgumentException("the machine id is illegal,the value rang 0 to " + this.maxMachineId);
        }
        this.centerId = centerId;
        this.machineId = machineId;
    }

    private synchronized long nextId() {
        long timestamp = getCurrentTimeStamp();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Abnormal clock, Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //处理同一个时间周期内的生成规则
        if (timestamp == lastTimestamp) {
            this.sequence = ++sequence & maxSequence;
            if (this.sequence == 0) {
                //当前序列使用完,直接进入下一个时钟周期
                timestamp = nextTimeMillis(lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }
        lastTimestamp = timestamp;
        return ((timestamp - this.epoch) << timestampShiftBits) | (centerId << centerShiftBits) | (machineId << sequenceBits) | sequence;

    }

    private long nextTimeMillis(long timemillis) {
        long current = getCurrentTimeStamp();
        while (current <= timemillis) {
            current = getCurrentTimeStamp();
        }
        return current;

    }

    private long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * @desciption createId 将一个64位数字转成一个16进制的字符串
     * @author xianchun
     * @date 11:43 2020/12/22
     */
    public synchronized String createId() {
        long id = this.nextId();
        return Long.toHexString(id);
    }

}
