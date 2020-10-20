package weight;

import lombok.Data;

/**
 * @author zhangyouhua
 * @date 2020/10/20 10:37
 */
@Data
class Server {
    private String ip;

    private int port;

    private int weight;

    public Server(String ip, int port, int weight) {
        this.ip = ip;
        this.port = port;
        this.weight = weight;
    }
}
