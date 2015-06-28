package de.hfu.SharityOnline;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Response;

import org.junit.Ignore;
import org.junit.Test;

import de.hfu.SharityOnline.entities.Page;
import de.hfu.SharityOnline.rest.PageRestSchnittstelle;

@Ignore
public class PagesTest {
  
  
  @Test
  public void tesTitle_zuLang() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setTitle("Muuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhhhhhhh");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 400);
  }
  
  @Test
  public void testTitle_zuKurz() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setTitle("");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 400);
  }
  
  @Test
  public void testTitle_valid() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setTitle("Hans Maier");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 200);
  }
  
  @Test
  public void testMetaDescription_zuLang() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setMeta_description("Muuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhhhhhhh");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 400);
  }
  
  @Test
  public void testMetaDescription_zuKurz() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setMeta_description("");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 400);
  }
  
  @Test
  public void testMetaDescription_valid() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setMeta_description("Hans Maier");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 200);
  }
  
  
  public void testMetaKeywords_zuLange() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setMeta_keywords("Muuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhuuuuuuuuuuuuuuuuuuuuuuuuuuuuhhhhhhhhhhhh");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 400);
  }
  
  @Test
  public void testMetaKeywords_zuKurz() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setMeta_keywords("");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 400);
  }
  
  @Test
  public void testMetaKeywords_valid() {
    PageRestSchnittstelle pageRest = new PageRestSchnittstelle();
    Page page = new Page();
    page.setMeta_keywords("Hans Maier");
    Response r = pageRest.createEntity(page);
    assertTrue(r.getStatus() == 200);
  }
  

}
