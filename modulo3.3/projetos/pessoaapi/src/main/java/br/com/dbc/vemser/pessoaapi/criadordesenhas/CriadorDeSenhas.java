package br.com.dbc.vemser.pessoaapi.criadordesenhas;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriadorDeSenhas {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);

        String minhaSenhaCript = "$2a$10$s5uZVk.qj9.FWvqcIXc/p.xkYiOuoIH4DJ45.N.3XVHeYFE8MTJ6a";
        boolean matches = bCryptPasswordEncoder.matches("123", minhaSenhaCript);
        System.out.println(matches);
    }
}
