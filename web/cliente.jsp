<%@page import="java.util.List"%>
<%@page import="entidades.Cliente"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="resources/js/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css"/>
    </head>
    <body>
        <h1>Cliente</h1>
        
        <%
            int id = 0;
            String nome = "";
            String telefone = "";
            String cpf = "";
            
            if (request.getAttribute("cliente") != null){
                Cliente ed = (Cliente)request.getAttribute("cliente");
                 
                id = ed.getId();
                nome = ed.getNome();
                telefone = ed.getTelefone();
                cpf = ed.getCpf();
            }
        %>

        <div class="container">
            <form method="POST" action="cliente">
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input class="form-control" type="hidden" id="nome" name="nome" required
                           value="<%= id %>"/>
                </div>
                
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input class="form-control" type="text" id="nome" name="nome" required
                           value="<%= nome %>"/>
                </div>

                <div class="form-group">
                    <label for="cpf">CPF:</label>
                    <input class="form-control" type="text" id="cpf" name="cpf" required
                           value="<%= cpf %>"/>
                </div>

                <div class="form-group">
                    <label for="telefone">Telefone:</label>
                    <input class="form-control" type="text" id="telefone" name="telefone" required
                           value="<%= telefone %>"/>
                </div>

                <button id="salvar" class="btn btn-success" type="submit">Salvar</button>
            </form>    
        </div>

        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Nome</th>
                        <th scope="col">CPF</th>
                        <th scope="col">Telefone</th>
                        <th scope="col"></th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        List<Cliente> lista;
                        lista = (List<Cliente>) request.getAttribute("lista");
                    %>
                    <% for (Cliente c : lista) {%>
                    <tr>
                        <td><%= c.getNome()%></td>
                        <td><%= c.getCpf()%></td>
                        <td><%= c.getTelefone()%></td>
                        <td>
                            <a href="cliente?editar=<%= c.getId() %>">
                                <button class="btn btn-primary">Editar</button>
                            </a>
                            <a href="cliente?excluir=<%= c.getId() %>">
                                <button class="btn btn-danger">Excluir</button>
                            </a>
                        </td>
                    </tr>
                    <%}%>

                </tbody>
            <table>
        </div>
    </body>
</html>