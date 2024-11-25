USE CarroJPA

SELECT * FROM locatario
SELECT * FROM aluguel
SELECT * FROM reparo
SELECT * FROM carro
SELECT * FROM categoria
SELECT * FROM devolucao


CREATE FUNCTION fn_dispCarro1()
RETURNS @tabela TABLE (
placa			VARCHAR(7),
ano				INT,
cor				VARCHAR(50),
kmRodado		INT,
marca			VARCHAR(30),
modelo			VARCHAR(80),
tipoCambio		VARCHAR(12),
tipoCombustivel VARCHAR(8),
codigoCategoria	INT
)
AS
BEGIN
	DECLARE @placa VARCHAR(7),
		@ano INT,
		@cor VARCHAR(50),
		@kmRodado INT,
		@marca VARCHAR(30),
		@modelo VARCHAR(80),
		@tipoCambio	VARCHAR(12),
		@tipoCombustivel VARCHAR(8),
		@codigoCategoria INT,
		@devolucao	DATE,
		@entrada	DATE,
		@qtdDias	INT,
		@vldDisp	BIT
		DECLARE c CURSOR FOR SELECT car.placa, car.ano, car.cor, car.kmRodado,
				car.marca, car.modelo, car.tipoCambio,car.tipoCombustivel, car.categoria
					FROM carro car														
				OPEN c
				FETCH NEXT FROM c INTO @placa, @ano, @cor, @kmRodado, @marca, @modelo, @tipoCambio, @tipoCombustivel,@codigoCategoria
					WHILE @@FETCH_STATUS = 0
					BEGIN
						SET @vldDisp = 0
						DECLARE d CURSOR LOCAL FOR SELECT dev.diaDeovolucao FROM carro car, aluguel al, devolucao dev
							WHERE car.placa = @placa
							AND al.codigoAluguel = dev.aluguel
						FETCH NEXT FROM d INTO @devolucao
						OPEN d
						WHILE @@FETCH_STATUS = 0
						BEGIN
							IF(@devolucao > GETDATE())
							BEGIN
								SET @vldDisp = 0
								FETCH NEXT FROM d INTO @devolucao
								CLOSE d
								DEALLOCATE d
							END
							ELSE
							BEGIN
								SET @vldDisp = 1
							END
							FETCH NEXT FROM d INTO @devolucao
						END
						CLOSE d
						DEALLOCATE d
							DECLARE r CURSOR FOR SELECT r.diaEntrada, r.qtdDiasReparo FROM carro car, reparo r
							WHERE car.placa = @placa
							AND r.carro = car.placa
						FETCH NEXT FROM r INTO @entrada,@qtdDias
						OPEN r
						WHILE @@FETCH_STATUS = 0
						BEGIN
							IF (DATEADD(DAY,@qtdDias,@entrada) >= GETDATE())
							BEGIN
								SET @vldDisp = 0
								FETCH NEXT FROM r INTO @devolucao
								CLOSE r
								DEALLOCATE r
							END
						END
							FETCH NEXT FROM r INTO @devolucao
							CLOSE r
							DEALLOCATE r
						
						IF(@vldDisp = 1)
						BEGIN 
							INSERT INTO @tabela VALUES( @placa, @ano, @cor, @kmRodado, @marca, @modelo, @tipoCambio, @tipoCombustivel,@codigoCategoria)
						END
						FETCH NEXT FROM c INTO @placa, @ano, @cor, @kmRodado, @marca, @modelo, @tipoCambio, @tipoCombustivel,@codigoCategoria
					END
					CLOSE c
					DEALLOCATE c
RETURN
END


SELECT * FROM fn_dispCarro1()
SELECT * FROM fn_dispCarro()