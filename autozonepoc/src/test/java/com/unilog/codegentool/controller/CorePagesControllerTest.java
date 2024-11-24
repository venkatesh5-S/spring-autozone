//package com.unilog.codegentool.controller;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.unilog.exception.poc.InvalidInputRequestException;
//import com.unilog.exception.poc.NameAlreadyExistsException;
//import com.unilog.exception.poc.ResourceNotFoundException;
//import com.unilog.request.poc.CorePagesRequestDto;
//import com.unilog.response.poc.CorePagesResponseDto;
//import com.unilog.service.poc.CorePagesService;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class CorePagesControllerTest {
//
//	@InjectMocks
//	private CorePagesController corePagesController;
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private CorePagesService corePagesService;
//
//	@MockBean
//	CorePagesResponseDto corePagesResponseDto;
//
//	@MockBean
//	CorePagesRequestDto corePagesRequestDto;
//
//	@Test
//	public void getCorePageTest() throws Exception {
//		Mockito.when(corePagesService.getCorePageDetails(Mockito.anyLong())).thenReturn(corePagesResponseDto);
//		mockMvc.perform(get("/core_pages/{id}", 1)).andExpect(status().isOk()).andDo(print()).andReturn();
//	}
//
//	@Test
//	public void getCorePageExceptionTest() throws Exception {
//		Mockito.when(corePagesService.getCorePageDetails(Mockito.anyLong()))
//				.thenThrow(new ResourceNotFoundException("Not found"));
//		mockMvc.perform(get("/core_pages/{id}", 1)).andExpect(status().is4xxClientError()).andDo(print()).andReturn();
//	}
//
//	@Test
//	public void getAllCorePagesTest() throws Exception {
//		List<CorePagesResponseDto> corePagesResponseList = new ArrayList<>();
//		corePagesResponseList.add(corePagesResponseDto);
//		Mockito.when(corePagesService.getAllCorePages()).thenReturn(corePagesResponseList);
//		mockMvc.perform(get("/core_pages/all", 1)).andExpect(status().isOk()).andDo(print()).andReturn();
//
//	}
////
////	@Test
////	public void saveCorePageWithJsonSourceTest() throws Exception {
////		Mockito.when(corePagesService.saveCorePageDetails(Mockito.any())).thenReturn(corePagesResponseDto);
////		mockMvc.perform(post("/core_pages").content(new ObjectMapper().writeValueAsString(corePagesRequestDto))
////				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
////				.andDo(print()).andReturn();
////	}
//
////	@Test
////	public void saveCorePageWithJsonSourceNameExistsExceptionTest() throws Exception {
////		Mockito.when(corePagesService.saveCorePageDetails(Mockito.any()))
////				.thenThrow(new NameAlreadyExistsException("Name already exists"));
////		mockMvc.perform(post("/core_pages").content(new ObjectMapper().writeValueAsString(corePagesRequestDto))
////				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
////				.andExpect(status().isConflict()).andDo(print()).andReturn();
////	}
//
////	@Test
////	public void saveCorePageWithJsonSourceExceptionTest() throws Exception {
////		Mockito.when(corePagesService.saveCorePageDetails(Mockito.any()))
////				.thenThrow(new InvalidInputRequestException("Invalid input"));
////		mockMvc.perform(post("/core_pages").content(new ObjectMapper().writeValueAsString(corePagesRequestDto))
////				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
////				.andExpect(status().is4xxClientError()).andDo(print()).andReturn();
////	}
//
//	@Test
//	public void updateCorePageTest() throws Exception {
//		Mockito.when(corePagesService.updateCorePage(Mockito.any(), Mockito.anyLong()))
//				.thenReturn(corePagesResponseDto);
//		mockMvc.perform(put("/core_pages/{id}", 1).content(new ObjectMapper().writeValueAsString(corePagesRequestDto))
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//				.andDo(print()).andReturn();
//	}
//
//	@Test
//	public void deleteCorePageTest() throws Exception {
//		Mockito.when(corePagesService.deleteCorePage(Mockito.anyLong())).thenReturn("Successfully 1 Deleted");
//		mockMvc.perform(delete("/core_pages/{id}", 1)).andExpect(status().isOk()).andDo(print()).andReturn();
//	}
//
//	@Test
//	public void getCorePageByNameTest() throws Exception {
//		Mockito.when(corePagesService.getPageName(Mockito.anyString())).thenReturn(corePagesResponseDto);
//		mockMvc.perform(get("/core_pages/name/{name}", "home")).andExpect(status().isOk()).andDo(print()).andReturn();
//	}
//
//}
