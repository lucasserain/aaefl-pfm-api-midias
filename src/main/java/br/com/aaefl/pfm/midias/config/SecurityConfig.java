package br.com.aaefl.pfm.midias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable();
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/frames").permitAll()
                .antMatchers(HttpMethod.GET, "/frames").permitAll()
                .antMatchers("/frames").permitAll()
                .antMatchers(HttpMethod.POST, "/videos").permitAll()
                .antMatchers(HttpMethod.GET, "/videos").permitAll()
                .antMatchers("/videos").permitAll()
                .antMatchers(HttpMethod.POST, "/relatorios/*").permitAll()
                .antMatchers(HttpMethod.GET, "/relatorios/*").permitAll()
                .antMatchers("/relatorios/*").permitAll()
                .antMatchers(HttpMethod.POST, "relatorios/aulas/*").permitAll()
                .antMatchers(HttpMethod.GET, "relatorios/aulas/*").permitAll()
                .antMatchers("relatorios/aulas/*").permitAll()
                .antMatchers(HttpMethod.POST, "relatorios/*/aulas/*").permitAll()
                .antMatchers(HttpMethod.GET, "relatorios/*/aulas/*").permitAll()
                .antMatchers("relatorios/*/aulas/*").permitAll()
                .antMatchers(HttpMethod.POST, "/usuarios/*").permitAll()
                .antMatchers(HttpMethod.GET, "/usuarios/*").permitAll()
                .antMatchers("/usuarios/*").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina").permitAll()
                .antMatchers("/disciplina").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*").permitAll()
                .antMatchers("/disciplina/*").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*/").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*/").permitAll()
                .antMatchers("/disciplina/*/").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*/aula").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*/aula").permitAll()
                .antMatchers("/disciplina/*/aula").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*/aluno").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*/aluno").permitAll()
                .antMatchers("/disciplina/*/aluno").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*/aluno/*").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*/aluno/*").permitAll()
                .antMatchers("/disciplina/*/aluno/*").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*/alunos").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*/alunos").permitAll()
                .antMatchers("/disciplina/*/alunos").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*/aulas").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*/aulas").permitAll()
                .antMatchers("/disciplina/*/aulas").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/*/professor").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/*/professor").permitAll()
                .antMatchers("/disciplina/*/professor").permitAll()
                .antMatchers(HttpMethod.POST, "/disciplina/usuario/*").permitAll()
                .antMatchers(HttpMethod.GET, "/disciplina/usuario/*").permitAll()
                .antMatchers("/disciplina/usuario/*us").permitAll()
                .antMatchers(HttpMethod.POST, "/relatorios/aulas/*").permitAll()
                .antMatchers(HttpMethod.GET, "/relatorios/aulas/*").permitAll()
                .antMatchers("/relatorios/aulas/*").permitAll()
                .antMatchers(HttpMethod.POST, "/aulas/*").permitAll()
                .antMatchers(HttpMethod.GET, "/aulas/*").permitAll()
                .antMatchers("/aulas/*").permitAll()
                .anyRequest().authenticated();

    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
