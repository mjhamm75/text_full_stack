import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import com.lowagie.examples.objects.images.DvdCover;
import com.lowagie.text.Image;

public class PdfTestRunner {

	private static String[] testClasses = new String[] { "com.lowagie.examples.directcontent.Layers",
			"com.lowagie.examples.directcontent.TemplateImages", "com.lowagie.examples.directcontent.Templates",
			"com.lowagie.examples.directcontent.colors.Groups", "com.lowagie.examples.directcontent.colors.Patterns",
			"com.lowagie.examples.directcontent.colors.Shading",
			"com.lowagie.examples.directcontent.colors.ShadingPattern",
			"com.lowagie.examples.directcontent.colors.SoftMask",
			"com.lowagie.examples.directcontent.colors.SpotColors",
			"com.lowagie.examples.directcontent.colors.Transparency",
			"com.lowagie.examples.directcontent.coordinates.AffineTransformation",
			"com.lowagie.examples.directcontent.coordinates.TransformImage",
			"com.lowagie.examples.directcontent.coordinates.Transformations",
			"com.lowagie.examples.directcontent.coordinates.UpsideDown",
			"com.lowagie.examples.directcontent.coordinates.XandYcoordinates",
			"com.lowagie.examples.directcontent.graphics.Circles",
			"com.lowagie.examples.directcontent.graphics.GState",
			"com.lowagie.examples.directcontent.graphics.Literal",
			"com.lowagie.examples.directcontent.graphics.Shapes",
			"com.lowagie.examples.directcontent.optionalcontent.Automatic",
			"com.lowagie.examples.directcontent.optionalcontent.ContentGroups",
			"com.lowagie.examples.directcontent.optionalcontent.NestedLayers",
			"com.lowagie.examples.directcontent.optionalcontent.OptionalContent",
			"com.lowagie.examples.directcontent.optionalcontent.OrderedLayers",
			"com.lowagie.examples.directcontent.pageevents.Bookmarks",
			"com.lowagie.examples.directcontent.pageevents.EndPage",
			"com.lowagie.examples.directcontent.pageevents.Events", "com.lowagie.examples.directcontent.text.Logo",
			"com.lowagie.examples.directcontent.text.Text", "com.lowagie.examples.fonts.EncodingFont",
			"com.lowagie.examples.fonts.FontEncoding", "com.lowagie.examples.fonts.FontFactoryType1Fonts",
			"com.lowagie.examples.fonts.FullFontNames", "com.lowagie.examples.fonts.ListEncodings",
			"com.lowagie.examples.fonts.StandardType1Fonts", "com.lowagie.examples.fonts.UnicodeExample",
			"com.lowagie.examples.fonts.getting.ChineseJapaneseKorean",
			"com.lowagie.examples.fonts.getting.FontFactoryStyles", "com.lowagie.examples.fonts.getting.OpenTypeFont",
			"com.lowagie.examples.fonts.getting.RegisterFont", "com.lowagie.examples.fonts.getting.TrueType",
			"com.lowagie.examples.fonts.getting.TrueTypeCollections",
			"com.lowagie.examples.fonts.getting.UsingFontFactory", "com.lowagie.examples.fonts.styles.ComplexText",
			"com.lowagie.examples.fonts.styles.ExtraStyles", "com.lowagie.examples.fonts.styles.FixedFontWidth",
			"com.lowagie.examples.fonts.styles.FontColor", "com.lowagie.examples.fonts.styles.FontStylePropagation",
			"com.lowagie.examples.fonts.styles.RightToLeft", "com.lowagie.examples.fonts.styles.Vertical",
			"com.lowagie.examples.fonts.styles.WidthHeight", "com.lowagie.examples.forms.FormCheckbox",
			"com.lowagie.examples.forms.FormCombo", "com.lowagie.examples.forms.FormList",
			"com.lowagie.examples.forms.FormPushButton", "com.lowagie.examples.forms.FormRadioButton",
			"com.lowagie.examples.forms.FormSignature", "com.lowagie.examples.forms.FormTextField",
			"com.lowagie.examples.forms.ListFields", "com.lowagie.examples.forms.SimpleRegistrationForm",
			"com.lowagie.examples.forms.TextFields", "com.lowagie.examples.forms.create.StudentCard",
			"com.lowagie.examples.forms.create.StudentCardForm", "com.lowagie.examples.forms.fill.FdfExample",
			"com.lowagie.examples.forms.fill.Register", "com.lowagie.examples.forms.fill.XfdfExample",
			"com.lowagie.examples.general.CustomPageSize", "com.lowagie.examples.general.DefaultPageSize",
			"com.lowagie.examples.general.HelloEncrypted", "com.lowagie.examples.general.HelloSystemOut",
			"com.lowagie.examples.general.HelloWorld", "com.lowagie.examples.general.HelloWorldMeta",
			"com.lowagie.examples.general.HelloWorldMultiple", "com.lowagie.examples.general.LandscapePortrait",
			"com.lowagie.examples.general.Margins", "com.lowagie.examples.general.copystamp.AddWatermarkPageNumbers",
			"com.lowagie.examples.general.copystamp.ConcatenateForms",
			"com.lowagie.examples.general.copystamp.EncryptorExample",
			"com.lowagie.examples.general.copystamp.TwoOnOne", "com.lowagie.examples.general.faq.Measurements",
			"com.lowagie.examples.general.faq.NewPage", "com.lowagie.examples.general.faq.PdfVersion",
			"com.lowagie.examples.general.faq.iTextVersion", "com.lowagie.examples.general.read.Info",
			"com.lowagie.examples.general.read.ReadEncrypted", "com.lowagie.examples.html.HelloHtml",
			"com.lowagie.examples.html.ImagesURL", "com.lowagie.examples.html.JavaScriptAction",
			"com.lowagie.examples.objects.Chunks", "com.lowagie.examples.objects.DifferentFonts",
			"com.lowagie.examples.objects.FancyLists", "com.lowagie.examples.objects.FontSelection",
			"com.lowagie.examples.objects.Lists", "com.lowagie.examples.objects.NegativeLeading",
			"com.lowagie.examples.objects.ParagraphAttributes", "com.lowagie.examples.objects.Paragraphs",
			"com.lowagie.examples.objects.Phrases", "com.lowagie.examples.objects.SpaceWordRatio",
			"com.lowagie.examples.objects.SymbolSubstitution", "com.lowagie.examples.objects.anchors.AHref",
			"com.lowagie.examples.objects.anchors.Actions", "com.lowagie.examples.objects.anchors.Annotations",
			"com.lowagie.examples.objects.anchors.ChainedActions",
			"com.lowagie.examples.objects.anchors.LocalDestination", "com.lowagie.examples.objects.anchors.LocalGoto",
			"com.lowagie.examples.objects.anchors.NamedActions",
			"com.lowagie.examples.objects.anchors.OpenApplication", "com.lowagie.examples.objects.anchors.RemoteGoto",
			"com.lowagie.examples.objects.anchors.SimpleAnnotations",
			"com.lowagie.examples.objects.bookmarks.ChapterSection",
			"com.lowagie.examples.objects.bookmarks.Destinations",
			"com.lowagie.examples.objects.bookmarks.OutlineActions",
			"com.lowagie.examples.objects.bookmarks.PageLabels",
			"com.lowagie.examples.objects.bookmarks.ViewerPreferences",
			"com.lowagie.examples.objects.chunk.Background", "com.lowagie.examples.objects.chunk.ChunkColor",
			"com.lowagie.examples.objects.chunk.EndOfLine", "com.lowagie.examples.objects.chunk.Generic",
			"com.lowagie.examples.objects.chunk.Glossary", "com.lowagie.examples.objects.chunk.Hyphenation",
			"com.lowagie.examples.objects.chunk.Lines", "com.lowagie.examples.objects.chunk.Rendering",
			"com.lowagie.examples.objects.chunk.Skew", "com.lowagie.examples.objects.chunk.SplitChar",
			"com.lowagie.examples.objects.chunk.SubSupScript", "com.lowagie.examples.objects.chunk.Width",
			"com.lowagie.examples.objects.columns.Column", "com.lowagie.examples.objects.columns.ColumnIrregular",
			"com.lowagie.examples.objects.columns.ColumnObjects", "com.lowagie.examples.objects.columns.ColumnSimple",
			"com.lowagie.examples.objects.columns.MultiColumnIrregular",
			"com.lowagie.examples.objects.columns.MultiColumnR2L",
			"com.lowagie.examples.objects.columns.MultiColumnSimple",
			"com.lowagie.examples.objects.images.AbsolutePositions", "com.lowagie.examples.objects.images.Alignment",
			"com.lowagie.examples.objects.images.AnnotatedImage", "com.lowagie.examples.objects.images.DvdCover",
			"com.lowagie.examples.objects.images.ImageChunks", "com.lowagie.examples.objects.images.ImageMasks",
			"com.lowagie.examples.objects.images.ImageSequence", "com.lowagie.examples.objects.images.Images",
			"com.lowagie.examples.objects.images.RawData", "com.lowagie.examples.objects.images.Rotating",
			"com.lowagie.examples.objects.images.Scaling", "com.lowagie.examples.objects.images.tiff.Barcodes",
			"com.lowagie.examples.objects.images.tiff.ExampleEAN128",
			"com.lowagie.examples.objects.images.tiff.ExamplePDF417",
			"com.lowagie.examples.objects.images.tiff.OddEven", "com.lowagie.examples.objects.images.tiff.Tiff2Pdf",
			"com.lowagie.examples.objects.tables.AddBigTable", "com.lowagie.examples.objects.tables.CellAlignment",
			"com.lowagie.examples.objects.tables.CellColors", "com.lowagie.examples.objects.tables.CellHeights",
			"com.lowagie.examples.objects.tables.CellPaddingLeading", "com.lowagie.examples.objects.tables.CellWidths",
			"com.lowagie.examples.objects.tables.DefaultCell", "com.lowagie.examples.objects.tables.ImageCell",
			"com.lowagie.examples.objects.tables.SplitRows", "com.lowagie.examples.objects.tables.TableBorders",
			"com.lowagie.examples.objects.tables.TableSpacing",
			"com.lowagie.examples.objects.tables.TableWidthAlignment",
			"com.lowagie.examples.objects.tables.alternatives.LargeCell",
			"com.lowagie.examples.objects.tables.alternatives.MyFirstTable",
			"com.lowagie.examples.objects.tables.alternatives.NestedTables",
			"com.lowagie.examples.objects.tables.alternatives.OldTable",
			"com.lowagie.examples.objects.tables.alternatives.PaddingBorders",
			"com.lowagie.examples.objects.tables.alternatives.RepeatingTable",
			"com.lowagie.examples.objects.tables.alternatives.SpecificCells",
			"com.lowagie.examples.objects.tables.alternatives.TablePdfPTable",
			"com.lowagie.examples.objects.tables.alternatives.TableWithImage",
			"com.lowagie.examples.objects.tables.pdfptable.CellEvents",
			"com.lowagie.examples.objects.tables.pdfptable.FloatingBoxes",
			"com.lowagie.examples.objects.tables.pdfptable.FragmentTable",
			"com.lowagie.examples.objects.tables.pdfptable.SplitTable",
			"com.lowagie.examples.objects.tables.pdfptable.TableEvents1",
			"com.lowagie.examples.objects.tables.pdfptable.TableEvents2",
			"com.lowagie.examples.objects.tables.pdfptable.Tables",
			"com.lowagie.examples.objects.tables.pdfptable.VerticalTextInCells",
			"com.lowagie.examples.objects.tables.pdfptable.WriteSelectedRows",
			"com.lowagie.examples.directcontent.colors.Pattern", "com.lowagie.examples.directcontent.graphics.State", };

	public static void main(String[] args) {
		Thread t = new Thread() {

			public void run() {
				int success = 0;
				for (final String className : testClasses) {
					System.out.println("Trying to run " + className + "\n");
					String result = null;
					try {
						Class<?> c = Class.forName(className);
						Method main = c.getDeclaredMethod("main", String[].class);
						
						String[] params = null;
						if(className.equals("com.lowagie.examples.objects.tables.pdfptable.FragmentTable")) {
							params = new String[] { "3" };
						} else if(className.equals("com.lowagie.examples.objects.images.tiff.OddEven")) {
							params = new String[] { "odd.tif", "even.tif", "odd_even.tiff" };
						} else if(className.equals("com.lowagie.examples.objects.images.tiff.Tiff2Pdf")) {
							params = new String[] { "12.tif" };
						} else if(className.equals("com.lowagie.examples.objects.images.DvdCover")) {
							params = new String[] { "dvdcover.png", "Title",  "0xff0000", "hitchcock.png"};
						} else if(className.equals("com.lowagie.examples.forms.ListFields")) {
							params = new String[] {};
						} else if(className.equals("com.lowagie.examples.general.read.Info")) {
							params = new String[] { "RomeoJuliet.pdf" };
						} else if(className.equals("com.lowagie.examples.objects.anchors.OpenApplication")) {
							params = new String[] { "" };
						}
						
						main.invoke(null, (Object) params);

						success++;
						result = "Successful";
					} catch (Exception e) {
						result = "Failed with exception: " + e.getClass().getName() + ": " + e.getMessage();
						// e.printStackTrace();
					}
					final String finalResult = result;
					if (finalResult.startsWith("Failed")) {
						System.err.println("Result: " + finalResult);
					} else {
						System.out.println("Result: " + finalResult);
					}
				}
				final int finalSuccess = success;
				System.out.println(finalSuccess + "/" + testClasses.length + " successful");
			}

		};
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
