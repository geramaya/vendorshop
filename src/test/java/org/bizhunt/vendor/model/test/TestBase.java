package org.bizhunt.vendor.model.test;

import org.bizhunt.vendor.WicketApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { WicketApplication.class, H2TestProfileJPAConfig.class })
@ActiveProfiles("test")

public class TestBase {

}
