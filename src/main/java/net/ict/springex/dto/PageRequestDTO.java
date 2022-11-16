package net.ict.springex.dto;
//페이지처리는 현재 페이지 번호(page), 한페이지당 데이터수(size) 기본적으로 필요하다.
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder //빌더를 사용해서 정보를 겟셋 입력해줄 수 있다.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    @Builder.Default //디폴트로 지정한다.
    @Min(value = 1) //최소 시작값을 지정한다.
    @Positive //양수만 처리한다.
    private  int page = 1;

    @Builder.Default //size의 디폴트 기본값을 정해준다.
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size =10;

    public int getSkip(){
        return (page-1)*10;
    }

//    private String link;
//    public String getLink() {
//        if(link == null){
//            StringBuilder builder = new StringBuilder();
//            builder.append("page=" + this.page);
//            builder.append("&size=" + this.size);
//            link = builder.toString();
//        }
//        return link;
//    }
}
