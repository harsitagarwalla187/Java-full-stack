import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerialConfig extends ObjectOutputStream {
    public SerialConfig(OutputStream os) throws IOException {
        super(os);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
