import java.util.List;
import java.util.Scanner;

import controller.TeamItemHelper;
import model.TeamItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static TeamItemHelper tih = new TeamItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the City to Add: ");
			String city = in.nextLine();
			System.out.print("Enter the Nick Name to Add: ");
			String nickName = in.nextLine();
			System.out.print("Enter the number of playes to Add: ");
			int numOfPlayers = in.nextInt();
			TeamItem toAdd = new TeamItem(city, nickName, numOfPlayers);
			tih.insertItem(toAdd);
		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the City to delete: ");
			String city = in.nextLine();
			System.out.print("Enter the Nick Name to delete: ");
			String nickName = in.nextLine();
			System.out.print("Enter the number of playes to delete: ");
			int numOfPlayers = in.nextInt();
			TeamItem toDelete = new TeamItem(city, nickName, numOfPlayers);
			tih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by City");
			System.out.println("2 : Search by Nick Name");
			int searchBy = in.nextInt();
			in.nextLine();
			List<TeamItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the city: ");
				String cityName = in.nextLine();
				foundItems = tih.searchForItemByCity(cityName);
				
			} else {
				System.out.print("Enter the nick name: ");
				String nickName = in.nextLine();
				foundItems = tih.searchforItemByNickName(nickName);

			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (TeamItem t : foundItems) {
					System.out.println(t.getId() + " : " + t.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				TeamItem toEdit = tih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getNickName() + " from " + toEdit.getCity() + "With " + toEdit.getNumOfPlayers() + " Players");
				System.out.println("1 : Update city");
				System.out.println("2 : Update nick name");
				System.out.println("3 : Update number of players");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New City: ");
					String newCity = in.nextLine();
					toEdit.setCity(newCity);
				} else if (update == 2) {
					System.out.print("New Nick Name: ");
					String newNickName = in.nextLine();
					toEdit.setNickName(newNickName);
				}
				else if (update == 3) {
					System.out.println("New number of players");
					int newNumOfPlayer = in.nextInt();
					toEdit.setNumOfPlayers(newNumOfPlayer);
				}

				tih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					tih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			List<TeamItem> allItems = tih.showAllItems();
			for(TeamItem singleItem : allItems) {
				System.out.println(singleItem.returnItemDetails());
			}
			

		}

	}