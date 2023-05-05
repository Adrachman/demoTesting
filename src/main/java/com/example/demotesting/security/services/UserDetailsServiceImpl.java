package com.example.demotesting.security.services;

import com.example.demotesting.models.Client;
import com.example.demotesting.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String clientname) throws UsernameNotFoundException {
        Client client = clientRepository.findByClientname(clientname)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + clientname));

        return ClientDetailsImpl.build(client);
    }
}