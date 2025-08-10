import java.util.List;
import java.util.ArrayList;

interface Observer {
    void update(String channelName, String videoName);
}
interface Subject {
    void addObs(Observer subs);
    void removeObs(Observer subs);
    void notifyObs(String videoName);
    void uploadVideo(String videoName);
}
class Subscriber implements Observer {
    private String name;
    Subscriber(String name) {
        this.name = name;
    }
    @Override
    public void update(String channelName, String videoName) {
        System.out.println("Hii " + name +", " + channelName + "'s video is out : " + videoName);
    }
}
class YoutubeChannel implements Subject {
    private String channelName;
    YoutubeChannel(String channelName) {
        this.channelName = channelName;
    }
    
    private List<Observer> array = new ArrayList<>();
    @Override
    public void addObs(Observer subs) {
        array.add(subs);
    }
    
    @Override
    public void removeObs(Observer subs) {
        array.remove(subs);
    }
    
    @Override
    public void notifyObs(String videoName) {
        for (Observer it : array) {
            it.update(channelName, videoName);
        }
    }
    
    @Override
    public void uploadVideo(String videoName) {
        notifyObs(videoName);
    }
}
public class Main {
    public static void main(String[] args) {
        Subject mrBeast = new YoutubeChannel("mrBeast");
        Subscriber gaurav = new Subscriber("golo");
        mrBeast.addObs(gaurav);
        Subscriber prabhat = new Subscriber("gay");
        mrBeast.addObs(prabhat);
        Subscriber saurabh = new Subscriber("saurabhia");
        mrBeast.addObs(saurabh);
        mrBeast.uploadVideo("100M dollars");
        mrBeast.uploadVideo("car giveaway");
}
}
