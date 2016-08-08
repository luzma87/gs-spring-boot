package hello.models;

public class ResponseSuccess {
    private final String content;

    public ResponseSuccess(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
