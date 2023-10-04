package bank.service.controller;

import bank.service.model.BankAccount;
import bank.service.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute BankAccount account, Model model) {
        accountService.save(account);
        return "redirect:/";
    }

    @GetMapping("/viewAddMoney/{id}")
    public String pageAddMoney(@PathVariable("id") int id, Model model) {
        var optionalAccount = accountService.findById(id);
        if (optionalAccount.isPresent()) {
            model.addAttribute("account", optionalAccount.get());
            return "pageAddMoney";
        }
        model.addAttribute("message", "Not found");
        return "404";
    }

    @GetMapping("/viewTransfer/{id}")
    public String transfer(@PathVariable("id") int id, Model model) {
        var optionalAccount = accountService.findById(id);
        if (optionalAccount.isPresent()) {
            model.addAttribute("account", optionalAccount.get());
            return "pageTransfer";
        }
        model.addAttribute("message", "Not found");
        return "404";
    }

    @PostMapping("/updateAccountNumber")
    public String addMoney(@ModelAttribute BankAccount account, Model model,
                           @RequestParam("validPin") int validPin) {
        if (account.getPin() == validPin) {
            accountService.update(account);
            return "redirect:/";
        }
        model.addAttribute("message", "Not valid pin-code");
        return "404";
    }
}
