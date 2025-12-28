package org.employee.Exception;

import java.time.LocalDateTime;

public class ErrorResponse
{
	private final LocalDateTime timestamp;

	private final String message;

	private final String error;

	private final int status;

	public ErrorResponse(int value , String reasonPhrase , String message)
	{
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.error = reasonPhrase;
		this.status = value;
	}

	public LocalDateTime getTimestamp()
	{
		return timestamp;
	}

	public String getMessage()
	{
		return message;
	}

	public String getError()
	{
		return error;
	}

	public int getStatus()
	{
		return status;
	}
}
