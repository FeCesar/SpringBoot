package br.com.academy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.dao.AlunoDao;
import br.com.academy.model.Aluno;

@Controller
public class AlunoController {
    
    @Autowired
    private AlunoDao alunoRepositorio;

    @GetMapping("formAluno")
    public ModelAndView formAlunos(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("InsertAlunos")
    public ModelAndView inserirAluno(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/alunos-adicionados");
        alunoRepositorio.save(aluno);
        return mv;
    }

    @GetMapping("alunos-adicionados")
    public ModelAndView listagemAlunos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/listaAlunos");
        mv.addObject("alunosList", alunoRepositorio.findAll());
        return mv;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Integer id){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/editar");
        Aluno aluno = alunoRepositorio.getOne(id);
        mv.addObject("aluno", aluno);
        return mv;
    }

    @PostMapping("/editar")
    public ModelAndView editar(Aluno aluno){
        ModelAndView mv = new ModelAndView();
        alunoRepositorio.save(aluno);
        mv.setViewName("redirect:/alunos-adicionados");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno(@PathVariable("id") Integer id){
        alunoRepositorio.deleteById(id);
        return "redirect:/alunos-adicionados";
    }

    @GetMapping("/filtro-alunos")
    public ModelAndView filtroAlunos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/pesquisa");
        return mv;
    }

    @GetMapping("/alunos-ativos")
    public ModelAndView listaAlunosAtivos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-ativos");
        mv.addObject("alunosAtivos", alunoRepositorio.findByStatusAtivo());
        return mv;
    }

    @GetMapping("/alunos-inativos")
    public ModelAndView listaAlunosInativos(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-inativos");
        mv.addObject("alunosInativos", alunoRepositorio.findByStatusInativo());
        return mv;
    }

    @GetMapping("/alunos-trancados")
    public ModelAndView listaAlunosTrancado(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-trancados");
        mv.addObject("alunosTrancados", alunoRepositorio.findByStatusTrancado());
        return mv;
    }

    @GetMapping("/alunos-cancelados")
    public ModelAndView listaAlunosCancelados(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-cancelados");
        mv.addObject("alunosCancelados", alunoRepositorio.findByStatusCancelado());
        return mv;
    }

    @PostMapping("/pesquisar-aluno")
    public ModelAndView pesquisarAluno(@RequestParam(required = false) String nome){
        ModelAndView mv = new ModelAndView();
        List<Aluno> listAlunos;
        if(nome == null || nome.trim().isEmpty()){
            listAlunos = alunoRepositorio.findAll();
        }else{
            listAlunos = alunoRepositorio.findByNomeContainingIgnoreCase(nome);
        }

        mv.addObject("ListaAlunos", listAlunos);
        mv.setViewName("aluno/pesquisa-resultado");
        return mv;
   
    }

}
