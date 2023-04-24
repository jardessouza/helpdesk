package br.com.jardessouza.resources.documentation;

import br.com.jardessouza.domain.dtos.ChamadoRequest;
import br.com.jardessouza.domain.dtos.ChamadoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ChamadoResourceDocs {
    @Operation(summary = "Operacao de buscar id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamado encontrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Chamado nao encontrado")})
    ResponseEntity<ChamadoResponse> findById(Integer id);

    @Operation(summary = "Operacao para listar todos os chamados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamados listados com sucesso")})
    ResponseEntity<List<ChamadoResponse>> listAll();

    @Operation(summary = "Operacao para criar chamado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamado criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Campos obrigatorios ausentes")})
    ResponseEntity<ChamadoResponse> create(ChamadoRequest request);

    @Operation(summary = "Operacao para atualizar chamado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamado atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Campos obrigatorios ausentes"),
            @ApiResponse(responseCode = "403", description = "Chamado nao encontrado")

    })
    ResponseEntity<Void> update(Integer id, ChamadoRequest request);

    @Operation(summary = "Operacao para deletar chamado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamado deletado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Chamado nao encontrado")})
    ResponseEntity<Void> delete(Integer id);
}
