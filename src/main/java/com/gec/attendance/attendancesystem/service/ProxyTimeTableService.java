package com.gec.attendance.attendancesystem.service;

import com.gec.attendance.attendancesystem.model.ProxyTimeTable;
import com.gec.attendance.attendancesystem.repository.ProxyTimeTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProxyTimeTableService {

    private ProxyTimeTableRepository proxyTimeTableRepository;

    public ProxyTimeTableService(ProxyTimeTableRepository proxyTimeTableRepository) {
        this.proxyTimeTableRepository = proxyTimeTableRepository;
    }

    public void addProxy(ProxyTimeTable proxyTimeTable){
        proxyTimeTableRepository.save(proxyTimeTable);
    }

    public List<ProxyTimeTable> getProxyTimeTable(){
        List<ProxyTimeTable> proxyTimeTables = proxyTimeTableRepository.findAll();

        return proxyTimeTables;
    }
}
