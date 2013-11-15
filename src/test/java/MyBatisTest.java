import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dylan.dao.PortalDocumentMapper;
import com.dylan.web.controller.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class MyBatisTest {
	@Autowired
	PortalDocumentMapper portalDocumentMapper;

	@Test
	public void testConnect() throws Exception {
		portalDocumentMapper.selectByPrimaryKey(1l);
	}
}
