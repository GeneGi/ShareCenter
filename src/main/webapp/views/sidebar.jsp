
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div class="sidebar" id="sidebar">

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
	</script>

	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
			<button class="btn btn-success">
				快
			</button>

			<button class="btn btn-info">
				捷
			</button>

			<button class="btn btn-warning">
				菜
			</button>

			<button class="btn btn-danger">
				单
			</button>
		</div>

		<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span>

			<span class="btn btn-info"></span>

			<span class="btn btn-warning"></span>

			<span class="btn btn-danger"></span>
		</div>
	</div><!-- #sidebar-shortcuts -->

	<ul class="nav nav-list">
		<li class="active">
			<a href="/">
				<i class="icon-dashboard"></i>
				<span class="menu-text"> 首页 </span>
			</a>
		</li>
		
		<li class="">
			<a href="/login">
				<i class="icon-comment-alt"></i>
				<span class="menu-text"> 登录&amp;注册 </span>
			</a>
		</li>

		<li>
			<a href="/jqgrid">
				<i class="icon-text-width"></i>
				<span class="menu-text"> jqgrid测试</span>
			</a>
		</li>

		<li>
			<a href="/admin" class="dropdown-toggle">
				<i class="icon-desktop"></i>
				<span class="menu-text"> 管理员</span>

				<b class="arrow icon-angle-down"></b>
			</a>

			<ul class="submenu">
				<li>
					<a href="/admin/user">
						<i class="icon-double-angle-right"></i>
						用户管理
					</a>
				</li>

				<li>
					<a href="/admin/article">
						<i class="icon-double-angle-right"></i>
						文章管理
					</a>
				</li>

				<li>
					<a href="/admin/file">
						<i class="icon-double-angle-right"></i>
						文件管理
					</a>
				</li>

			</ul>
		</li>

		<li>
			<a href="/upload">
				<i class="icon-list-alt"></i>
				<span class="menu-text"> 分享资料 </span>
			</a>
		</li>

	</ul><!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
	</script>
</div>