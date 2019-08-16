<%@page import="beans.ShopDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/modalShop.css">

<div id="cont-sale-shop-all">

	<div id="cont-sale-shop">

		<h3>Lista de artículos</h3>
		
		${ mshop }

		<div class="cont-articles-shop">
			
			<%
				ArrayList<ShopDTO> glord = (ArrayList<ShopDTO>)request.getSession().getAttribute("glord");
			
				if(glord != null) {
					for(ShopDTO s : glord) { %>
						
						<article class="article-shop">
						<a href="carrito?option=dlt&i=<%=glord.indexOf(s)%>" class="btn_remove_article" title="Remover artículo">X</a>
						<input type="hidden" value="<%=glord.indexOf(s)%>">
						<div class="article-shop-img">
							<img src="images/content/products/<%=s.getImgProd()%>" alt="">
						</div>

						<div class="article-shop-desc">
							<h4><%=s.getNomProd()%></h4>
							<div class="shop-desc">
								<div>
									<label>Precio:</label><span>S/</span> <span><%=s.getPreProd()%></span>
								</div>
								<div>
									<label for="k">Cantidad:</label><input type="text" readonly value="<%=s.getCantProd()%>" min="1">
								</div>
							</div>
							<div>
								<label>Total: &nbsp;</label> <label>S/</label><label><%=s.getSubTotalProd()%></label>
							</div>
						</div>
						
					</article>
				<%	}
				}%>
			
		</div>

		<div class="cont-shop-prices">

			<div class="shop-prices">
				<span>Subtotal:</span>
				<div>
					<span>S/</span> <span>${ subTotal }</span>
				</div>
			</div>

			<div class="shop-prices">
				<span>Descuento:</span>
				<div>
					<span>S/</span> <span>${ descuentoShop }</span>
				</div>
			</div>

			<div class="shop-prices">
				<span>Total:</span>
				<div>
					<span>S/</span> <span>${ totalShop }</span>
				</div>
			</div>

		</div>

		<div class="cont-shop-btn">
			<a href="#" class="btn_shop_products">Cancelar</a>
			<% if(glord != null) { %>
				<a href="shopSale.jsp" target="_blank" class="btn_shop_products">Ir al carrito</a>
			<%}
			%>
		</div>
			<button type="button" id="cont-icon-shop">
				<img src="images/complements/carshop.png" alt="">
				<span>${ cantArt }</span>
			</button>
	</div>
	
	<script>
		
	</script>
</div>