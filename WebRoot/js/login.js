$(document).ready(function() {

	$("#loginForm").submit(function() {
		//任何一项为空内容都不允许提交
		var check = false;
		$(".sub").each(function() {
			if ($(this).val() == "") {
				check = true;
			}
			if ($("#loginName").val() == "") {
				$("#spName").text("请输入用户名");
			}
			if ($("#loginPassword").val() == "") {
				$("#spPsw").text("请输入密码");
			}
		});
		if (check) {
			return false;
		}
	});
	$("#loginForm").submit(function() {
		if ($("#confPassword").val() == "") {
			$("#spCfPsw").text("请输入确认密码");
			return false;
		}
	});

	$("#loginPassword").focusin(function() {
		$("#loginPassword").val("");
		$(this).css("color", "black");
		$(".msgRegDiv").css("visibility", "hidden");
		$("#spPsw").text("");

	});
	$("#confPassword").focusin(function() {
		$("#confPassword").val("");
		$(this).css("color", "black");
		$(".msgRegDiv").css("visibility", "hidden");
		$("#spCfPsw").text("");
	});

	$("#loginPassword").blur(function() {
		if ($(this).val() != $("#confPassword").val()) {
			$("#spCfPsw").text("两次密码不正确");

		} else {
			$("#spPsw").text("");
			$("#spCfPsw").text("");
		}
	});
	$("#confPassword").blur(function() {
		if ($("#loginPassword").val() != $(this).val()) {
			$("#spPsw").text("两次密码不正确");
		} else {
			$("#spPsw").text("");
			$("#spCfPsw").text("");
		}
	});

	$("input").focusin(function() {
		$(this).css("color", "black");
	});
});