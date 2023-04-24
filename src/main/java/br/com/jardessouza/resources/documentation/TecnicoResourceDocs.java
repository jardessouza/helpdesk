package br.com.jardessouza.resources.documentation;

import br.com.jardessouza.domain.dtos.ChamadoRequest;
import br.com.jardessouza.domain.dtos.ChamadoResponse;
import br.com.jardessouza.domain.dtos.TecnicoRequest;
import br.com.jardessouza.domain.dtos.TecnicoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TecnicoResourceDocs {
    @Operation(summary = "Operacao de buscar tecnico por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tecnico encontrado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Tecnico nao encontrado")})
    ResponseEntity<TecnicoResponse> findById(Integer id);

    @Operation(summary = "Operacao para listar todos os Tecnicos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tecnicos listados com sucesso")})
    ResponseEntity<List<TecnicoResponse>> listAll();

    @Operation(summary = "Operacao para criar Tecnico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tecnico criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Campos obrigatorios ausentes")})
    ResponseEntity<TecnicoResponse> create(TecnicoRequest request);

    @Operation(summary = "Operacao para atualizar Tecnico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tecnico atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Campos obrigatorios ausentes"),
            @ApiResponse(responseCode = "403", description = "Tecnico nao encontrado")

    })
    ResponseEntity<Void> update(Integer id, TecnicoRequest request);

    @Operation(summary = "Operacao para deletar Tecnico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tecnico deletado com sucesso"),
            @ApiResponse(responseCode = "403", description = "Tecnico nao encontrado")})
    ResponseEntity<Void> delete(Integer id);
}
