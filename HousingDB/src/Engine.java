public class Engine  {
    theSystem s=new theSystem();

    public void runStart() throws InterruptedException{
        s.start();
    }
    public void runBody() throws InterruptedException{
        s.run();
    }

}
