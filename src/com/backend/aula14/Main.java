package com.backend.aula14;

import com.backend.aula14.model.Contato;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<>();

        Contato pessoa1 = new Contato("Felipe", "fe@gmail.com", "999999");
        Contato pessoa2 = new Contato("Matheus", "ma@gmail.com", "888888");
        Contato pessoa3 = new Contato("Vinicius", "vini@gmail.com", "777777");
        Contato pessoa4 = new Contato("Romulo", "ro@gmail.com", "666666");

        contatos.add(pessoa1);
        contatos.add(pessoa2);
        contatos.add(pessoa3);
        contatos.add(pessoa4);

        FileOutputStream fileOut = null;
        try{
            fileOut = new FileOutputStream("ListaContatos.txt");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut); // salvar o objeto

            objOut.writeObject(contatos);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

        //Para ler um arquivo
        List<Contato> contatos2 = null;
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream("ListaContatos.txt");
            ObjectInputStream objInput = new ObjectInputStream(fileInput);

            contatos2 = (ArrayList) objInput.readObject(); //leu objeto e transformou na lista


        }catch (FileNotFoundException e){
            System.out.println("erro no arquivo");
        }catch (Exception e){
            e.printStackTrace();
        }

        for(Contato pessoa: contatos2){
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Email: " + pessoa.getEmail());
            System.out.println("Telefone: " + pessoa.getTelefone());
            System.out.println("------------------------------");
        }



	// write your code here
    }
}
