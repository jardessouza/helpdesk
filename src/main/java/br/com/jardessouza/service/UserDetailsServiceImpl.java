package br.com.jardessouza.service;

import br.com.jardessouza.domain.Pessoa;
import br.com.jardessouza.repository.PessoaRepository;
import br.com.jardessouza.security.UserSS;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         Optional<Pessoa> user = this.pessoaRepository.findByEmail(email);
         if (user.isPresent()){
             return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getSenha(), user.get().getPerfis());
         }
         throw  new UsernameNotFoundException(email);
    }
}
