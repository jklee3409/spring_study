package hello.core.singleton;

public class SingletonService {

    // static으로 객체를 하나 생성해 놓음
    private static final SingletonService instance = new SingletonService();

    // SingletonService 객체를 참조 하고 싶은 경우, getInstance 메서드를 통해 호출
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언하여 외부에서, new 키워드로 객체를 함부로 생성할 수 없도록 함.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
