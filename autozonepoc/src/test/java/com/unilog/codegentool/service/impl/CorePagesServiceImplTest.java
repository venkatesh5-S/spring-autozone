//package com.unilog.codegentool.service.impl;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.unilog.entity.poc.CorePages;
//import com.unilog.exception.poc.NameAlreadyExistsException;
//import com.unilog.exception.poc.ResourceNotFoundException;
//import com.unilog.repository.poc.CorePagesRepository;
//import com.unilog.request.poc.CorePagesRequestDto;
//import com.unilog.response.poc.CorePagesResponseDto;
//import com.unilog.utility.poc.StringToObjectConverterUtil;
//
//@SpringBootTest
//class CorePagesServiceImplTest {
//
//	@InjectMocks
//	CorePagesServiceImpl corePagesServiceImpl;
//
//	@Mock
//	CorePagesRepository corePagesRepository;
//
//	@Mock
//	StringToObjectConverterUtil stringToObjectConverterUtil;
//
//	@Test
//	void getCorePageDetailsTest() {
//		CorePages corePages = getCorePages();
//		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
//		Mockito.when(corePagesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(corePages));
//		CorePagesResponseDto corePagesResponseDto = corePagesServiceImpl.getCorePageDetails(1);
//		assertEquals("Home Page", corePagesResponseDto.getPageName());
//	}
//
//	@Test
//	void getCorePageDetailsExceptionTest() {
//		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
//		Mockito.when(corePagesRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
//		assertThatThrownBy(() -> corePagesServiceImpl.getCorePageDetails(1))
//				.isInstanceOf(ResourceNotFoundException.class);
//	}
//
//	@Test
//	void getAllCorePageDetailsTest() {
//		CorePages corePages = getCorePages();
//		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
//		List<CorePages> list = new ArrayList<>();
//		list.add(corePages);
//		Mockito.when(corePagesRepository.findAll()).thenReturn(list);
//		List<CorePagesResponseDto> corePagesResponseDto = corePagesServiceImpl.getAllCorePages();
//		assertEquals(1, corePagesResponseDto.size());
//	}
//
////	@Test
////	public void saveCorePageDetailsTest() {
////		CorePagesRequestDto corePagesRequestDto = getCorePagesRequestDto();
////		CorePages corePages = getCorePages();
////		Mockito.when(stringToObjectConverterUtil.convertToDatabaseColumn(Mockito.any()))
////				.thenReturn(corePages.getPageSource());
////		Mockito.when(corePagesRepository.save(Mockito.any())).thenReturn(corePages);
////		Mockito.when(corePagesRepository.findByPageNameIgnoreCase(Mockito.anyString())).thenReturn(new ArrayList<>());
////		CorePagesResponseDto corePagesResponseDto = corePagesServiceImpl.saveCorePageDetails(corePagesRequestDto);
////		assertEquals("Home Page", corePagesResponseDto.getPageName());
////	}
//
////	@Test
////	public void saveCorePageDetailsPageNameConflictTest() {
////		CorePagesRequestDto corePagesRequestDto = getCorePagesRequestDto();
////		CorePages corePages = getCorePages();
////		Mockito.when(stringToObjectConverterUtil.convertToDatabaseColumn(Mockito.any()))
////				.thenReturn(corePages.getPageSource());
////		Mockito.when(corePagesRepository.save(Mockito.any())).thenReturn(corePages);
////		List<CorePages> corePagesList = new ArrayList<>();
////		corePagesList.add(corePages);
////		Mockito.when(corePagesRepository.findByPageNameIgnoreCase(Mockito.anyString())).thenReturn(corePagesList);
////		assertThatThrownBy(() -> corePagesServiceImpl.saveCorePageDetails(corePagesRequestDto))
////				.isInstanceOf(NameAlreadyExistsException.class);
////	}
//
////	@Test
////	public void updateCorePageTest() {
////		CorePagesRequestDto corePagesRequestDto = getCorePagesRequestDto();
////		corePagesRequestDto.setPageName("Home Page1");
////		corePagesRequestDto.setPageDescription("page Desc");
////		corePagesRequestDto.setUpdatedBy("test Updated");
////		CorePages corePages = getCorePages();
////		Mockito.when(stringToObjectConverterUtil.convertToDatabaseColumn(Mockito.any()))
////				.thenReturn(corePages.getPageSource());
////		Mockito.when(corePagesRepository.save(Mockito.any())).thenReturn(corePages);
////		Mockito.when(corePagesRepository.findByPageNameIgnoreCase(Mockito.anyString())).thenReturn(new ArrayList<>());
////		Mockito.when(corePagesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(corePages));
////		CorePagesResponseDto corePagesResponseDto = corePagesServiceImpl.updateCorePage(corePagesRequestDto, 1);
////		assertEquals("Home Page1", corePagesResponseDto.getPageName());
////	}
//
////	@Test
////	void updateCorePageExceptionTest() {
////		CorePagesRequestDto corePagesRequestDto = getCorePagesRequestDto();
////		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
////		Mockito.when(corePagesRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
////		assertThatThrownBy(() -> corePagesServiceImpl.updateCorePage(corePagesRequestDto, 1))
////				.isInstanceOf(ResourceNotFoundException.class);
////	}
//
//	@Test
//	void deleteCorePageTest() {
//		CorePages corePages = getCorePages();
//		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
//		Mockito.when(corePagesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(corePages));
//		String response = corePagesServiceImpl.deleteCorePage(1);
//		assertEquals("Successfully 1 Deleted", response);
//	}
//
//	@Test
//	void deleteCorePageExceptionTest() {
//		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
//		Mockito.when(corePagesRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
//		assertThatThrownBy(() -> corePagesServiceImpl.deleteCorePage(1)).isInstanceOf(ResourceNotFoundException.class);
//	}
//
//	@Test
//	public void getPageNameTest() {
//		CorePages corePages = getCorePages();
//		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
//		Mockito.when(corePagesRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(corePages));
//		List<CorePages> corePagesList = new ArrayList<>();
//		corePagesList.add(corePages);
//		Mockito.when(corePagesRepository.findByPageNameIgnoreCase(Mockito.anyString())).thenReturn(corePagesList);
//		CorePagesResponseDto corePagesResponseDto = corePagesServiceImpl.getPageName("Home Page");
//		assertEquals("Home Page", corePagesResponseDto.getPageName());
//	}
//
//	@Test
//	void getPageNameExceptionTest() {
//		Mockito.when(stringToObjectConverterUtil.convertToResponseObject(Mockito.anyString())).thenReturn(new Object());
//		Mockito.when(corePagesRepository.findByPageNameIgnoreCase(Mockito.anyString())).thenReturn(new ArrayList<>());
//		assertThatThrownBy(() -> corePagesServiceImpl.getPageName("Home Page"))
//				.isInstanceOf(ResourceNotFoundException.class);
//	}
//
////	private CorePagesRequestDto getCorePagesRequestDto() {
////		CorePagesRequestDto corePagesRequestDto = new CorePagesRequestDto();
////		corePagesRequestDto.setPageName("Home Page");
////		Object obj = new Object();// { "key":"value"});
////		Map<String, String> map = new HashMap<>();
////		map.put("key", "value");
////		obj = map;
////		corePagesRequestDto.setPageSource(obj);
////		corePagesRequestDto.setCreatedBy("test");
////		corePagesRequestDto.setPageDescription("desc");
////		corePagesRequestDto.setUpdatedBy("Test");
////		return corePagesRequestDto;
////	}
//
//	private CorePages getCorePages() {
//		CorePages corePages = new CorePages();
//		corePages.setId(1l);
//		corePages.setPageName("Home Page");
//		corePages.setPageDescription("desc");
//		corePages.setPageSource("{\"key\":\"value\"}");
//		corePages.setUpdatedBy("test");
//		return corePages;
//	}
//
//
//
//}
