package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import reader.XMLReader;
import model.dto.FlashCardAppDTO;
import writer.CSVWriter;
import writer.IStackWriter;

public class Main {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Message");
		try {
		    String input = JOptionPane.showInputDialog(frame, "Command:");
		    Command command = resolveCommand(input);
		    FlashCardAppDTO flashCardApp = XMLReader.resolveFile(command.getPathXml());
		    command.getEnum().getWriterClazz().newInstance().writeStacksToFile(command.getOutputNamePattern(), command.getPathOutput(), flashCardApp);
			JOptionPane.showMessageDialog(frame,
					"Files generated!",
				    "Result",
				    JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame,
				    e.getMessage(),
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static Command resolveCommand(String input) {
		String[] inputs = input.split("\\s+");
		return new Command(inputs[0], inputs[1], inputs[2], inputs[3]);
	}
	
	public static class Command{
		private String command;
		private String pathXml;
		private String pathOutput;
		private String outputNamePattern;
		
		public static enum CommandEnum{
			csv("csv",CSVWriter.class);
			
			private String name;
			private Class<? extends IStackWriter> writerClazz;
			
			private <T extends IStackWriter> CommandEnum(String name, Class<T> writerClazz){
				this.name = name;
				this.writerClazz = writerClazz;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Class<? extends IStackWriter> getWriterClazz() {
				return writerClazz;
			}

			public <T extends IStackWriter> void setWriterClazz(Class<T> writerClazz) {
				this.writerClazz = writerClazz;
			}
			
			public static CommandEnum getWriterByName(String name) {
				for(CommandEnum writer : CommandEnum.values()) {
					if(writer.name.equals(name))
						return writer;
				}
				return null;
			}
		}
		
		
		public Command(String command, String pathXml, String pathOutput, String outputNamePattern) {
			super();
			this.command = command;
			this.pathXml = pathXml;
			this.pathOutput = pathOutput;
			this.outputNamePattern = outputNamePattern;
		}
		
		public String getCommand() {
			return command;
		}
		public void setCommand(String command) {
			this.command = command;
		}
		public String getPathXml() {
			return pathXml;
		}
		public void setPathXml(String pathXml) {
			this.pathXml = pathXml;
		}
		public String getOutputNamePattern() {
			return outputNamePattern;
		}
		public void setOutputNamePattern(String outputNamePattern) {
			this.outputNamePattern = outputNamePattern;
		}
		
		public CommandEnum getEnum() {
			return CommandEnum.valueOf(getCommand());
		}

		public String getPathOutput() {
			return pathOutput;
		}

		public void setPathOutput(String pathOutput) {
			this.pathOutput = pathOutput;
		}
	}
}
