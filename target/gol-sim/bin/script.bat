@echo 0 : %0
@echo * : %*

@echo cmd : %CmdCmdLine%
@echo d0 : %~d0
@echo p0 : %~p0
@echo n0 : %~n0
@echo x0 : %~x0
@echo f0 : %~f0

@set JLINK_VM_OPTIONS=
@set DIR=%~p0
@echo %DIR%java %JLINK_VM_OPTIONS% -m tk.workshop.learn.App %*
