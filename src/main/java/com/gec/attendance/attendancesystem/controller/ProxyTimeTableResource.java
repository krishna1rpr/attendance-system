package com.gec.attendance.attendancesystem.controller;

import com.gec.attendance.attendancesystem.model.ProxyTimeTable;
import com.gec.attendance.attendancesystem.service.ProxyTimeTableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proxyTimeTable")
public class ProxyTimeTableResource {

    private ProxyTimeTableService proxyTimeTableService;

    public ProxyTimeTableResource(ProxyTimeTableService proxyTimeTableService) {
        this.proxyTimeTableService = proxyTimeTableService;
    }

    @PostMapping("/addProxy")
    public String addProxy(@RequestBody ProxyTimeTable proxyTimeTable){
        System.out.println(proxyTimeTable);
        proxyTimeTableService.addProxy(proxyTimeTable);

        return "Proxy Added!";
    }

    @GetMapping("/getProxyTimeTable")
    public List<ProxyTimeTable> getProxyTimeTable(){
        return proxyTimeTableService.getProxyTimeTable();
    }
}
