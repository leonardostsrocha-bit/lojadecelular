package projeto.lojadecelular.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import projeto.lojadecelular.model.celular;
import projeto.lojadecelular.repository.lojar;

@Controller
public class lojacontroller {

    @Autowired
    private lojar lojar;

    @GetMapping("/")
    public String home() {
        return "redirect:/celulares";
    }

    @GetMapping("/celulares")
    public String listar(Model model) {
        List<celular> lista = lojar.findAll();

        long emEstoque = lista.stream().filter(c -> c.getEstoque() > 0).count();
        long marcas = lista.stream().map(c -> c.getMarca()).distinct().count();

        model.addAttribute("celulares", lista);
        model.addAttribute("celular", new celular());
        model.addAttribute("totalProdutos", lista.size());
        model.addAttribute("emEstoque", emEstoque);
        model.addAttribute("totalMarcas", marcas);
        return "loja";
    }

    @PostMapping("/celulares")
    public String cadastrar(@ModelAttribute celular celular, RedirectAttributes ra) {
        lojar.save(celular);
        ra.addFlashAttribute("mensagem", "Celular cadastrado com sucesso!");
        ra.addFlashAttribute("tipo", "sucesso");
        return "redirect:/celulares";
    }

    @GetMapping("/celulares/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        List<celular> lista = lojar.findAll();

        long emEstoque = lista.stream().filter(c -> c.getEstoque() > 0).count();
        long marcas = lista.stream().map(c -> c.getMarca()).distinct().count();

        model.addAttribute("celular", lojar.findById(id).orElseThrow());
        model.addAttribute("celulares", lista);
        model.addAttribute("totalProdutos", lista.size());
        model.addAttribute("emEstoque", emEstoque);
        model.addAttribute("totalMarcas", marcas);
        return "loja";
    }

    @PostMapping("/celulares/atualizar")
    public String atualizar(@ModelAttribute celular celular, RedirectAttributes ra) {
        lojar.save(celular);
        ra.addFlashAttribute("mensagem", "Celular atualizado com sucesso!");
        ra.addFlashAttribute("tipo", "sucesso");
        return "redirect:/celulares";
    }

    @GetMapping("/celulares/deletar/{id}")
    public String deletar(@PathVariable Long id, RedirectAttributes ra) {
        lojar.deleteById(id);
        ra.addFlashAttribute("mensagem", "Celular excluído!");
        ra.addFlashAttribute("tipo", "danger");
        return "redirect:/celulares";
    }
}