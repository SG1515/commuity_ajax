import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void 실험_assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    void ObjectMapper__objToJsonStr() {
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");
        // Json으로 변환하거나 defaultValue로 달라.
        String jsonStr = Ut.json.toStr(articleDto, "");
        assertThat(jsonStr).isNotBlank();
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"제목","body":"내용"}
                """.trim()); //큰 따옴표를 하나만 하면 /로 다 끊어주어야함.
    }


    @Test
    void ObjectMapper__jsonStrToObj() {
        ArticleDto articleDtoOrigin = new ArticleDto(1, "제목", "내용");
        String jsonStr = Ut.json.toStr(articleDtoOrigin, "");


        ArticleDto articleDtoFromJson = Ut.json.toObj(jsonStr, ArticleDto.class, null);
        assertThat(articleDtoOrigin).isEqualTo(articleDtoFromJson);
    }
    // 자바의 리스트 == js 배열
    // 자바의 맵, 객체 == js 객체
    @Test
    void ObjectMapper__articleDtoListToJsonStr() {
        List<ArticleDto> articleDtos = new ArrayList<>();
        articleDtos.add(new ArticleDto(1, "제목1", "내용1"));
        articleDtos.add(new ArticleDto(2, "제목2", "내용2"));

        String jsonStr = Ut.json.toStr(articleDtos, "");
        assertThat(jsonStr).isEqualTo("""
                [{"id":1,"title":"제목1","body":"내용1"},{"id":2,"title":"제목2","body":"내용2"}]
                """.trim());
    }

    @Test
    void ObjectMapper__articleDtoMapToJsonStr() {
        Map<String, ArticleDto> articleDtoMap = new HashMap<>();
        articleDtoMap.put("가장오래된", new ArticleDto(1, "제목1", "내용1"));
        articleDtoMap.put("최신", new ArticleDto(2, "제목2", "내용2"));

        String jsonStr = Ut.json.toStr(articleDtoMap, "");
        assertThat(jsonStr).isEqualTo("""
                {"가장오래된":{"id":1,"title":"제목1","body":"내용1"},"최신":{"id":2,"title":"제목2","body":"내용2"}}
                """.trim());
    }


}
