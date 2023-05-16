package builder;

public class Computer {
    private int RAM;
    private String CPU;
    private int storage;
    private String MB;
    private int Battery;
    private String color;
    private String Video;

    private Computer(Builder builder) {
        this.RAM = builder.RAM;
        this.CPU = builder.CPU;
        this.storage = builder.storage;
        this.Battery = builder.Battery;
        this.color = builder.color;
        this.MB = builder.MB;
        this.Video = builder.Video;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "RAM=" + RAM +
                ", CPU='" + CPU + '\'' +
                ", storage=" + storage +
                ", MB='" + MB + '\'' +
                ", Battery=" + Battery +
                ", color='" + color + '\'' +
                ", Video='" + Video + '\'' +
                '}';
    }

    public static class Builder {
        private int RAM;
        private String CPU;
        private int storage;
        private String MB;
        private int Battery;
        private String color;
        private String Video;

        public Builder(String MB, String CPU) {
            this.MB = MB;
            this.CPU = CPU;
        }

        public Computer build() {
            return new Computer(this);
        }
        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setBattery(int battery) {
            Battery = battery;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setVideo(String video) {
            Video = video;
            return this;
        }
    }
}
