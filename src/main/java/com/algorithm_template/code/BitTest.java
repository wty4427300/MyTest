package com.algorithm_template.code;

public class BitTest {
    public static void main(String[] args) {
        BitTest bitParams = new BitTest();
        bitParams.getData(1 | 4);
        bitParams.getData(1 | 2 | 4);
    }

    private void getData(int flag) {
        System.out.println("return result:");
        for (DataEnum dataEnum : DataEnum.values()) {
            if ((flag & dataEnum.getIndex()) != 0) {
                System.out.println(flag & dataEnum.getIndex());
                System.out.println(dataEnum.getDataFiled());
            }
        }
    }

    public enum DataEnum {
        DATA_FILED_1(1, "DATA_FILED_1"),
        DATA_FILED_2(2, "DATA_FILED_2"),
        DATA_FILED_4(4, "DATA_FILED_4");

        private final int index;
        private final String dataFiled;

        DataEnum(int index, String dataFiled) {
            this.index = index;
            this.dataFiled = dataFiled;
        }

        public int getIndex() {
            return index;
        }

        public String getDataFiled() {
            return dataFiled;
        }
    }
}
