import java.util.Arrays;

public enum Pipe implements Handler {
    @Meta(packet="transfering...", packetID=1)
    TRANSFER {
        @Override
        public Pipe operateAndTransfer(String... data) {
            if(data.length < 2)
                return ERROR;
            System.out.println("Annotations : "+Arrays.toString(this.getClass().getAnnotations()));
            return TRANSFER;
        }
    },
    @Meta(packet="checking balance...", packetID=12)
    CHECK {
        @Override
        public Pipe operateAndTransfer(String... data) {
            return TRANSFER;
        }
    },
    @Meta(packet="authenticating the user...", packetID=15)
    AUTHENTICATE {
        @Override
        public Pipe operateAndTransfer(String... data) {
            return null;
        }
    },
    @Meta(packet="error in pipeline...", packetID=145)
    ERROR {
        @Override
        public Pipe operateAndTransfer(String... data) throws Exception {
            throw new Exception();
        }
    }
}
