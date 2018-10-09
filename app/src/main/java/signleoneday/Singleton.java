package signleoneday;

/**
 * Created by zhangpingzhen on 2018/10/9.
 */

public class Singleton {
    private  static  volatile  Singleton instance=null;

    private Singleton() {
    }
    public static Singleton getInstance(){
      if(instance==null){
          synchronized (Singleton.class){
              if (instance==null){
                  instance=new Singleton();
              }
          }
      }
        return instance;
    }
}
