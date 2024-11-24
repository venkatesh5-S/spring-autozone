//package com.unilog.codegentool.entity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class CorePagesTest {
//
//	@InjectMocks
//	private CorePages corePages;
//
//	@Test
//	public void corePagesTest() {
//		corePages = new CorePages();
//		corePages.setId(1l);
//		corePages.setPageName("Home");
//		corePages.setPageDescription("Desc");
//		corePages.setPageSource("{\"key\":\"value\"}");
//		corePages.setCreatedBy("test");
//		corePages.setUpdatedBy("test");
//		corePages.setCreatedDateTime(LocalDateTime.now());
//		corePages.setUpdatedDateTime(LocalDateTime.now());
////		CorePages corePages1 = new CorePages(2l, corePages.getPageName(), corePages.getPageDescription(),
////				corePages.getPageSource(), corePages.getCreatedBy(), corePages.getUpdatedBy(),
////				corePages.getCreatedDateTime(), corePages.getUpdatedDateTime());
//		assertEquals("Home", corePages.getPageName());
//		assertEquals(1l, corePages.getId());
//		assertEquals("Desc", corePages.getPageDescription());
//		assertEquals("{\"key\":\"value\"}", corePages.getPageSource());
//		assertEquals("test", corePages.getCreatedBy());
//		assertEquals("test", corePages.getUpdatedBy());
//		assertNotNull(corePages.toString());
//		assertNotNull(corePages.hashCode());
////		assertFalse(corePages.equals(corePages1));
//	}
//
//}
