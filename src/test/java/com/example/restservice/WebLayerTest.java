import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class WebLayerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void shouldReturnDefaultMessage() throws Exception {
            this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("Hello, World")));
        }
    }
}
