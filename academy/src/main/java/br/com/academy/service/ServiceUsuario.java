package br.com.academy.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academy.dao.UsuarioDao;
import br.com.academy.exceptions.CriptoExistException;
import br.com.academy.exceptions.EmailExistExeception;
import br.com.academy.exceptions.ServiceExc;
import br.com.academy.model.Usuario;
import br.com.academy.util.Util;

@Service
public class ServiceUsuario {
    
    @Autowired
    private UsuarioDao usuarioRepositorio;

    public void salvarUsuario(Usuario user) throws Exception{

        try{

            if(usuarioRepositorio.findByEmail(user.getEmail()) != null){
                throw new EmailExistExeception("Email já cadastrado para: " + user.getEmail());
            }

            user.setSenha(Util.md5(user.getSenha()));

        } catch(NoSuchAlgorithmException e){

            throw new CriptoExistException("Erro na criptografia da senha!");

        }

        usuarioRepositorio.save(user);

    }

    public Usuario loginUser(String user, String senha) throws ServiceExc{

        Usuario userLogin = usuarioRepositorio.findByLoginSenha(user, senha);
        return userLogin;

    }

}
