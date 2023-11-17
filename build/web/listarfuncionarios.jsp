

<%@page import="model.Funcionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="tabela.css">
        <title>Listar cursos</title>
        <style>
            p{
                text-align: center;
                font-size: 18px;
            }
        </style>
    </head>
    <body>
        <%
            List<Funcionario> listaFuncionarios = (List<Funcionario>)request.getAttribute("listaFuncionarios");
            %>
            <table border="1">
                <tr>
                    <th>Matricula</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Telefone</th>
                    <th>Cargo</th>
                </tr>
                
                    <%
                        for(Funcionario fun: listaFuncionarios){
                        
                        
                        %>
                <tr>
                    <td><%= fun.getMatricula() %> </td>
                    <td><%= fun.getNome() %></td>
                    <td><%= fun.getEmail() %></td>
                    <td><%= fun.getTelefone() %></td>
                    <td><%= fun.getCargo() %></td>
                </tr>
                    <%
                        }
                        %>
                
            </table><br>
                        
                        <p>
            <img  src="https://media.tenor.com/-AAA-k6jEFkAAAAM/bluepen.gif" alt="bluepen">
        </p>
    </body>
</html>
