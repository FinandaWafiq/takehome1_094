/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webservice.c.projectpenjualan;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LENOVO
 */
@Controller
public class TableController {
    
    @RequestMapping("/input")
    //@ResponseBody
    public String getData (HttpServletRequest data, Model discountprocess){
        
        String inputnama = data.getParameter("namabuah");
        
        String inputharga = data.getParameter("harga");
        
        String inputjumlah = data.getParameter("jumlahbeli");
        
        String total = data.getParameter("total");
        
        String diskon = "";
        Double Harga = Double.valueOf(inputharga);
        Double Total = Double.valueOf(inputjumlah);
        Double HargaTotal = Harga * Total;
        Double getTotal = null;
        
        if (HargaTotal < 10000)
        {
            getTotal = HargaTotal - (0 * HargaTotal/100);
            diskon = "0%";
        }
        else if (HargaTotal >= 10000 && HargaTotal < 50000)
        {
            getTotal = HargaTotal - (5 * HargaTotal/100);
            diskon = "5%";
        }
        else if (HargaTotal >= 50000 && HargaTotal <= 100000)
        {
            getTotal = HargaTotal - (10 * HargaTotal/100);
            diskon = "10%";
        }
        else if (HargaTotal > 100000)
        {
            getTotal = HargaTotal - (15 * HargaTotal/100);
            diskon = "15%";
        }
        
        discountprocess.addAttribute("namabuah", inputnama);
        discountprocess.addAttribute("harga", inputharga);
        discountprocess.addAttribute("jumlahbeli", inputjumlah);
        discountprocess.addAttribute("diskon", diskon);
        discountprocess.addAttribute("total", getTotal);
      
        return "TableViewer";
    }
}