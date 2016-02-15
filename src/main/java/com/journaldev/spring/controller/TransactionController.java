package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Transaction;
import com.journaldev.spring.service.TransactionService;

@Controller
public class TransactionController {
	
	private TransactionService transactionService;
	
	@Autowired(required=true)
	@Qualifier(value="transactionService")
	public void setTransactionService(TransactionService transactionService){
		this.transactionService = transactionService;
	}
	
	@RequestMapping(value="/transactions", method=RequestMethod.GET)
	public String listTransactions(Model model) {
		model.addAttribute("transaction", new Transaction());
		model.addAttribute("listTransactions", this.transactionService.listTransactions());
		return "transaction";
	}
	
	//For add and update transaction both
	@RequestMapping(value="/transaction/add", method=RequestMethod.POST)
	public String addTransaction(@ModelAttribute("transaction") Transaction transaction){
		if(transaction.getId() == 0){
			//new transaction, add it
			this.transactionService.addTransaction(transaction);
		}else{
			//existing transaction, call update
			this.transactionService.updateTransaction(transaction);
		}
		return "redirect:/transactions";
	}
	
	@RequestMapping("/transaction/remove/{id}")
    public String removeTransaction(@PathVariable("id") int id){
        this.transactionService.removeTransaction(id);
        return "redirect:/transactions";
    }
 
    @RequestMapping("/transaction/edit/{id}")
    public String editTransaction(@PathVariable("id") int id, Model model){
        model.addAttribute("transaction", this.transactionService.getTransactionById(id));
        model.addAttribute("listTransactions", this.transactionService.listTransactions());
        return "transaction";
    }
	
}
