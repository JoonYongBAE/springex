package net.ict.springex.mapper;

public interface TimeMapper2 {
    //TimeMapper에는select now()가 있지만 여기에는 없다. 이 방법은 다른 방법으로
    //xml을 만들어서 사용을 하는 방법이다.
    String getNow();
}
