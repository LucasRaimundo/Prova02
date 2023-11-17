
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmpresaDao;
import model.Funcionario;

/**
 *
 * @author LucasRaimundo
 */
@WebServlet(name = "ControleFuncionarios", urlPatterns = {"/ControleFuncionarios"})
public class ControleFuncionarios extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String flag;
        String mensagem;
        flag = request.getParameter("flag");
        if(flag.equals("cadastrar")){ //cadcur.html
            String matricula, nome, email, telefone, cargo;
            matricula = request.getParameter("matricula");
            nome = request.getParameter("nome");
            email = request.getParameter("email");
            telefone = request.getParameter("telefone");
            cargo = request.getParameter("cargo");
        
            
            Funcionario funcionario = new Funcionario();
            funcionario.setMatricula(matricula);
            funcionario.setNome(nome);
            funcionario.setEmail(email);
            funcionario.setTelefone(telefone);
            funcionario.setCargo(cargo);
        
            
            //chamar metod na universidadedao
            int resultado = new EmpresaDao().salvarFuncionario(funcionario);
            if(resultado==1){ // salvou
                mensagem = "Funcionario cadastrado com sucesso";
            } else { // n salvou
                mensagem ="Funcionario não cadastrado";
            }
            
            //empacota 
            request.setAttribute("mensagem", mensagem);
            //especificar pra onde vai
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            // envia pro jsp
            disp.forward(request, response);
            
            
             //fazer o cadastro
         } else if (flag.equals("listar")){ 
             List<Funcionario> lista = new EmpresaDao().listarFuncionarios();
             request.setAttribute("listaFuncionarios", lista);
             RequestDispatcher disp = request.getRequestDispatcher("listarfuncionarios.jsp");
             disp.forward(request, response);
         } 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
