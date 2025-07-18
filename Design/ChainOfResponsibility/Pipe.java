
import java.lang.reflect.Field;



public enum Pipe implements Handler {
    @Meta(packet="transfering...", packetID=1)
    TRANSFER {
        @Override
        public Pipe operateAndTransfer(String... data) throws NoSuchFieldException {
            Field f = Pipe.class.getField(this.name());
            Meta meta = f.getAnnotation(Meta.class);
            if(data.length < 2)
                return ERROR;
            System.out.println(meta.packet());
            return END;
        }
    },
    @Meta(packet="checking balance...", packetID=12)
    CHECK {
        @Override
        public Pipe operateAndTransfer(String... data) throws NoSuchFieldException {
            Field f = Pipe.class.getField(this.name());
            Meta meta = f.getAnnotation(Meta.class);
            if(data.length < 2)
                return ERROR;
            System.out.println(meta.packet());
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
    },
    @Meta(packet="Pipe Completed", packetID=200)
    END {
        @Override
        public Pipe operateAndTransfer(String... data) {
            System.out.println("Packet Delivered !!");
            return null;
        }
    }
}
