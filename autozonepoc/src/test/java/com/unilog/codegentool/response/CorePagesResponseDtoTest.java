//package com.unilog.codegentool.response;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.time.LocalDateTime;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.unilog.entity.poc.CorePages;
//
//@SpringBootTest
//class CorePagesResponseDtoTest {
//
//	@InjectMocks
//	CorePagesResponseDto corePagesResponseDto;
//
//	@Mock
//	CorePages corePages;
//
//	@Test
//	void corePagesResponseDtoTest() {
//		corePagesResponseDto = new CorePagesResponseDto();
//		corePagesResponseDto.setId(1l);
//		corePagesResponseDto.setPageName("Home Page");
//		corePagesResponseDto.setPageDescription("desc");
//		corePagesResponseDto.setPageSource("{\"key\":\"value\"}");
//		corePagesResponseDto.setCreatedBy("test");
//		corePagesResponseDto.setUpdatedBy("test");
//		corePagesResponseDto.setCreatedDateTime(LocalDateTime.now());
//		corePagesResponseDto.setUpdatedDateTime(LocalDateTime.now());
//		corePages = new CorePages();
//		corePages.setId(1l);
//		corePages.setPageName(corePagesResponseDto.getPageName());
//		corePages.setPageDescription(corePagesResponseDto.getPageDescription());
//		corePages.setPageSource(corePagesResponseDto.getPageSource());
//		corePages.setCreatedBy(corePagesResponseDto.getCreatedBy());
//		corePages.setUpdatedBy(corePagesResponseDto.getUpdatedBy());
//		corePages.setCreatedDateTime(corePagesResponseDto.getCreatedDateTime());
//		corePages.setUpdatedDateTime(corePagesResponseDto.getUpdatedDateTime());
//		CorePagesResponseDto corePagesResponseDto1 = new CorePagesResponseDto(corePages);
//		assertNotNull(corePagesResponseDto1.toString());
//		assertNotNull(corePagesResponseDto1.hashCode());
//		assertNotNull(corePagesResponseDto.getCreatedDateTime());
//		assertNotNull(corePagesResponseDto.getUpdatedDateTime());
//		assertEquals(1, corePagesResponseDto.getId());
//		assertEquals("Home Page", corePagesResponseDto.getPageName());
//		assertEquals("desc", corePagesResponseDto.getPageDescription());
//		assertEquals("{\"key\":\"value\"}", corePagesResponseDto.getPageSource());
//		assertEquals("test", corePagesResponseDto.getCreatedBy());
//		assertEquals("test", corePagesResponseDto.getUpdatedBy());
//		assertEquals(corePagesResponseDto, corePagesResponseDto1);
//	}
//
//}
