import com.fasterxml.jackson.core.JsonProcessingException;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void 실험_assertThat() {
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    void 실험_ObjectMapper() throws JsonProcessingException {
        ArticleDto articleDto = new ArticleDto(1, "제목", "내용");
        // Json으로 변환하거나 defaultValue로 달라.
        String jsonStr = Ut.json.toJsonStr(articleDto, "");
        assertThat(jsonStr).isNotBlank();
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"제목","body":"내용"}
                """.trim()); //큰 따옴표를 하나만 하면 /로 다 끊어주어야함.
    }
}
