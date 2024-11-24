package com.unilog.codegentool.request;

import com.autozone.poc.request.CorePagesRequestDto;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CorePagesRequestDtoTest {

	@InjectMocks
    CorePagesRequestDto corePagesRequestDto;

//	@Test
////	void corePagesRequestDtoTest() {
////
////		corePagesRequestDto = new CorePagesRequestDto();
////		corePagesRequestDto.setPageName("Home Page");
////		corePagesRequestDto.setPageDescription("Desc");
////		corePagesRequestDto.setUpdatedBy("Test");
////		corePagesRequestDto.setCreatedBy("test");
////		corePagesRequestDto.setPageSource(new Object());
////
////		CorePagesRequestDto corePagesRequestDto1 = new CorePagesRequestDto(corePagesRequestDto.getPageName(),
////				corePagesRequestDto.getPageDescription(), corePagesRequestDto, corePagesRequestDto.getCreatedBy(),
////				corePagesRequestDto.getUpdatedBy());
////		assertEquals("Home Page", corePagesRequestDto.getPageName());
////		assertNotNull(corePagesRequestDto.toString());
////		assertNotNull(corePagesRequestDto.hashCode());
////		assertFalse(corePagesRequestDto.equals(corePagesRequestDto1));
////	}

}
