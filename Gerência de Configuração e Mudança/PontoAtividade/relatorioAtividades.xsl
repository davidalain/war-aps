<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <xsl:output method="html" encoding="ISO-8859-1" indent="no"/>


  <xsl:template match="/">

    <html>
      <head>
        <title>Relatorio de atividades</title>
        <style>
          body,td {font-family:Tahoma,Arial; font-size:9pt;}
        </style>
      </head>



      <body bgcolor="#FFFFEE">
		<table border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td>	
					<table border="0" cellspacing="0" cellpadding="0" width="100%">
						<tr>
							<td width="10%">
								<img src="../imgs/logo.png"/>
							</td>
							<td>
								<font size="3"><b> pontoatividadedotnet </b></font><br/>
								<font size="2"><i> Timesheet desktop C# .NET </i></font>
							</td>
						</tr>
				</table>	
				</td>
			</tr>
			<tr><td><HR width="100%"/><br/></td></tr>
			<tr>
				<td>					
			        <font size="3"><b> Relatorio de atividades - <xsl:value-of select="atividades/@data" /></b></font>
				</td>
			</tr>
			<tr><td><br/></td></tr>
			<tr>
				<td>
			        <table border="1" width="100%">
			          <tr bgcolor="navy">
			            <td ><font color="white"><b>Atividade</b></font></td>
			            <td ><font color="white"><b>Duração</b></font></td>
			          </tr>
			          <xsl:for-each select="atividades/atividade">
			            <tr>
			              <td><b>
			                <xsl:value-of select="acao"/></b>
			              </td>
			              <td><b>
			                <xsl:value-of select="duracao"/></b>
			              </td>
			            </tr>
			          </xsl:for-each>
			        </table>
				</td>
			</tr>
			<tr>
				<td>
			        <br/><br/><br/>
					<center>
			        <h4>Tempo total - <b><xsl:value-of select="atividades/@tempoTotal" /></b></h4>
					</center>
				</td>
			</tr>
		</table>	
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>